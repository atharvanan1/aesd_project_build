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

# sed -i 's/LAYERSERIES_COMPAT_iot-cloud = "zeus dunfell"/LAYERSERIES_COMPAT_iot-cloud = "zeus dunfell thud"/g' ../layers/meta-iot-cloud/conf/layer.conf

bitbake-layers add-layer ../layers/meta-st/meta-aesd-project
bitbake-layers add-layer ../layers/meta-openembedded/meta-oe
bitbake-layers add-layer ../layers/meta-openembedded/meta-python
bitbake-layers add-layer ../layers/meta-openembedded/meta-filesystems
bitbake-layers add-layer ../layers/meta-virtualization
bitbake-layers add-layer ../layers/meta-rust
bitbake-layers add-layer ../layers/meta-iotedge
bitbake-layers add-layer ../layers/meta-iot-cloud

set -e
bitbake st-image-aesd
