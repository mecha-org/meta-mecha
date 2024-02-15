SUMMARY = "mctk-demo"
HOMEPAGE = "https://github.com/akshayr-mecha/mctk-demo"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/akshayr-mecha/mctk-demo.git;protocol=https;branch=main"
SRCREV="e10c8e8fd3d98948f2c9fcf210e0d1bc9f855afd"

S = "${WORKDIR}/git"

DEPENDS:append = " pkgconfig pkgconfig-native gtk4 libadwaita gtk4 gtk4-layer-shell"
