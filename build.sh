#! /bin/bash

# Name - Atharva Nandanwar
# File - flash.sh
# Purpose - Used to flash code into STM32MP1 connected through usb

DISTRO=openstlinux-weston MACHINE=stm32mp1 source ./layers/meta-st/scripts/envsetup.sh
bitbake st-image-weston