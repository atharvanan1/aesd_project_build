#! /bin/bash

# Name - Atharva Nandanwar
# File - build.sh
# Purpose - used to build for a target machine and distro

git submodule init
git submodule update --init --recursive
DISTRO=openstlinux-weston MACHINE=stm32mp1-aesd-project source ./layers/meta-st/scripts/envsetup.sh

if grep -q "virtualization" ./conf/local.conf; then
    echo -n ""
else
    echo "DISTRO_FEATURES_append=\" virtualization\"" >> ./conf/local.conf
fi

if grep -q "PACKAGECONFIG_pn-azure-iot-sdk-c_append" ./conf/local.conf; then
    echo -n ""
else
    echo "PACKAGECONFIG_pn-azure-iot-sdk-c_append = \"amqp mqtt uhttp edge\"" >> ./conf/local.conf
fi


bitbake-layers show-layers | grep "meta-aesd-project" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-aesd-project layer"
	bitbake-layers add-layer ../layers/meta-st/meta-aesd-project
else
	echo "meta-aesd-project layer already exists"
fi

bitbake-layers show-layers | grep "meta-oe" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-oe layer"
	bitbake-layers add-layer ../layers/meta-openembedded/meta-oe
else
	echo "meta-oe layer already exists"
fi

bitbake-layers show-layers | grep "meta-python" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-python layer"
	bitbake-layers add-layer ../layers/meta-openembedded/meta-python
else
	echo "meta-python layer already exists"
fi

bitbake-layers show-layers | grep "meta-filesystems" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-filesystems layer"
	bitbake-layers add-layer ../layers/meta-openembedded/meta-filesystems
else
	echo "meta-filesystems layer already exists"
fi

bitbake-layers show-layers | grep "meta-virtualization" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-virtualization layer"
	bitbake-layers add-layer ../layers/meta-virtualization
else
	echo "meta-virtualization layer already exists"
fi

bitbake-layers show-layers | grep "meta-rust" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-rust layer"
	bitbake-layers add-layer ../layers/meta-rust
else
	echo "meta-rust layer already exists"
fi

bitbake-layers show-layers | grep "meta-iotedge" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-iotedge layer"
	bitbake-layers add-layer ../layers/meta-iotedge
else
	echo "meta-iotedge layer already exists"
fi

bitbake-layers show-layers | grep "meta-qt5" > /dev/null
layer_info=$?
if [ $layer_info -ne 0 ];then
	echo "Adding meta-qt5 layer"
	bitbake-layers add-layer ../layers/meta-qt5
else
	echo "meta-qt5 layer already exists"
fi

set -e
bitbake st-image-aesd
