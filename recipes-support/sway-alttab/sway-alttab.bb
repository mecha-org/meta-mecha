SUMMARY = "sway-alttab"
HOMEPAGE = "https://github.com/ereduled/sway-alttab"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/ereduled/sway-alttab.git;protocol=https;branch=master"
SRCREV="1c6839e35427cdb03f9d89e1efdcf46e6e2a72a3"

S = "${WORKDIR}/git"

DEPENDS:append = " libgudev"
