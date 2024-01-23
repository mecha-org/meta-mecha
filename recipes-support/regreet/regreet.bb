SUMMARY = "ReGreet"
HOMEPAGE = "https://github.com/rharish101/ReGreet"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/rharish101/ReGreet.git;protocol=https;branch=main"
SRCREV="7c28a13948e07d8bc2106df6b07464526b0acbc0"

S = "${WORKDIR}/git"

DEPENDS:append = " cairo gtk4"
