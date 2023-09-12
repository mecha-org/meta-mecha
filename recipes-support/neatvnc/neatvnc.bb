DESCRIPTION = "neatvnc"
SECTION = "Mywork"
LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

#inherit pkgconfig

SRC_URI = "git://github.com/any1/neatvnc;branch=master;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "56f1c125fa77da10b4b40ca97d978d8903207ff8"

#DEPENDS = " openssl"
#do_configure[noexec] = "1"
#TARGET_CC_ARCH += "${LDFLAGS}"

DEPENDS = " pkgconfig pkgconfig-native \ 
    aml \
    wayland \
    wayland-protocols \
    wayland-native \
    wayland-utils \
    libxkbcommon \
    drm \
    libxkbcommon \
    pixman \
    jansson \
"

#CFLAGS = "--sysroot=${SDKTARGETSYSROOT} -mfloat-abi=hard"

#do_compile() {
#        oe_runmake -C ${S}
#}

#do_compile() {
#         ${CC} led_blink_06.c -o led_blink_06
#}

#do_install() {
#         install -d ${D}${bindir}
#         install -m 0755 led_blink_06 ${D}${bindir}
#}

inherit meson 

PACKAGES += "${PN}-systemd"

FILES:${PN}-systemd += "${libdir}/systemd"