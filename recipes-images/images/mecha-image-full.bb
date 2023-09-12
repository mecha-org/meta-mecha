# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston','', d)} \
"

SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    curl \
    ${CLINFO} \
    ${DOCKER} \
"

#IMAGE_INSTALL:remove = " coreutils"
CLINFO              ?= ""
CLINFO:imxgpu        = "clinfo"
CLINFO:mx8mm-nxp-bsp = ""
CLINFO:mx7-nxp-bsp   = ""

DOCKER            ?= ""
DOCKER:mx8-nxp-bsp = "docker"

export IMAGE_BASENAME = "mecha-image-core"

#-----------------------------------------------------------------------------------

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-pulseaudio \
    packagegroup-core-weston \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
"

IMAGE_INSTALL:append = " connman connman-client" 
IMAGE_INSTALL:append = " mesa mesa-demos"     
IMAGE_INSTALL:append = " bluez5"     

IMAGE_INSTALL:append = " cage"
IMAGE_INSTALL:append = " sway"
IMAGE_INSTALL:append = " way-vnc neatvnc"

# poky/meta/recipes-graphics/xorg-app/
IMAGE_INSTALL:append = " xhost xauth"

# Media files to test audio-video & photos
IMAGE_INSTALL:append = " test-files"

IMAGE_INSTALL:append = " swaylock swayidle swaybg"
IMAGE_INSTALL:append = " waybar rot8"
IMAGE_INSTALL:append = " nwg-drawer"
IMAGE_INSTALL:append = " nwg-dock"
IMAGE_INSTALL:append = " zsh"
