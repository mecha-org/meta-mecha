SUMMARY = "yazi"
HOMEPAGE = "https://github.com/sxyazi/yazi"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cargo_bin

# Enable network for the compile task allowing cargo to download dependencies
do_compile[network] = "1"

SRC_URI = "git://github.com/sxyazi/yazi.git;protocol=https;branch=main"
SRCREV="a735b3234f2da36ef9c85581b94414a5acdbd16f"

S = "${WORKDIR}/git"

# remove PSEUDO path mismatch error
PACKAGE_DEBUG_SPLIT_STYLE = "debug-without-src"

RDEPENDS:${PN} = "glib-2.0 gtk4"

DEPENDS = " gdk-pixbuf gtk4 libadwaita"
