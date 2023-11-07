SUMMARY = "lisgd - Gesture Detection Tool for Wayland, X11"
SECTION = "support"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0008babdc0540ac1e924dd102e1a4c1b"

SRC_URI = "git://github.com/shoaibmerchant/lisgd.git;protocol=https;branch=master"

SRCREV = "2087fbe090509cfbe4d61ed1fccad886b14f0060"

S = "${WORKDIR}/git"

DEPENDS += " libinput wayland"

# compiles for wayland
EXTRA_OEMAKE += "WITHOUT_X11='1'"

# compiles for x11
# EXTRA_OEMAKE[wayland] += "WITHOUT_WAYLAND='1'"

# INSANE_SKIP:${PN} = "ldflags"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile () {
	oe_runmake
}

do_install () {
	oe_runmake install 'DESTDIR=${D}'
}
