SUMMARY = "wgpu03"
HOMEPAGE = "https://github.com/shoaibmerchant/wgpu03"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/shoaibmerchant/wgpu03.git;protocol=https;branch=main"
SRCREV="d360c04dc5ba5ed02f846e24ac1eba16a0c31623"

S = "${WORKDIR}/git"

DEPENDS:append = " pkgconfig pkgconfig-native gtk4 libadwaita gtk4 gtk4-layer-shell"
