SUMMARY = "alacritty"
HOMEPAGE = "https://github.com/alacritty/alacritty"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake cargo_bin  

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/alacritty/alacritty.git;protocol=https;branch=v0.13"

SRCREV="fe2a3c566759c9926150181006bd56cb2293ae10"

S = "${WORKDIR}/git"
 
DEPENDS:append = " fontconfig"
 