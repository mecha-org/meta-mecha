SUMMARY = "swhkd"
HOMEPAGE = "https://github.com/waycrate/swhkd"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/waycrate/swhkd.git;protocol=https;branch=main"
SRCREV="30f25b5bf99df5f16d91b51a7bd397c1de075085"

S = "${WORKDIR}/git"

DEPENDS:append = " libgudev"
