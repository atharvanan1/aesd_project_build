#! /bin/bash

# Name - Atharva Nandanwar
# File - flash.sh
# Purpose - Used to flash code into STM32MP1 connected through usb

DISTRO=openstlinux-weston MACHINE=stm32mp1 source ./layers/meta-st/scripts/envsetup.sh

echo "DISTRO_FEATURES_append=\" virtualization\"" >> ./conf/local.conf

bitbake-layers add-layer ../layers/meta-st/meta-aesd-project
bitbake-layers add-layer ../layers/meta-openembedded/meta-oe
bitbake-layers add-layer ../layers/meta-openembedded/meta-python
bitbake-layers add-layer ../layers/meta-openembedded/meta-filesystems
bitbake-layers add-layer ../layers/meta-virtualization
bitbake-layers add-layer ../layers/meta-rust
bitbake-layers add-layer ../layers/meta-iotedge

set -e
bitbake st-image-weston
