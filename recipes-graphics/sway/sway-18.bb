
SUMMARY = "A Wayland WM"
HOMEPAGE = "https://github.com/swaywm/sway"
BUGTRACKER = "https://github.com/swaywm/sway/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=dfc67e5b1fa10ebb4b70eb0c0ca67bea"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	wlroots-0.16 \
	cairo \
	libevdev \
	json-c \
	libdrm \
	libinput \
	libxkbcommon \
	pango \
	libpcre2 \
	pixman \
	virtual/libgles2 \
	wayland \
	wayland-native \
	wayland-protocols \
	scdoc \
	scdoc-native \
"
# sways default config makes use of it
RDEPENDS:${PN} ?= "swaybg python3 python-i3ipc"

RRECOMMENDS:${PN} ?= " \
	jq \
	grim \
	slurp \
	wl-clipboard \
"

SRC_URI = " \
	git://github.com/shoaibmerchant/sway.git;protocol=https;branch=feat_show_titlebars\
	file://0001-feat-adds-support-for-handling-minimize-toplevel.patch;patch=1 \
"

SRCREV = "1cdeffbe06360cf4e70d3e8de1d7a7e116186978"
PV = "1.8.1"
S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

PACKAGECONFIG[basu] = "-Dsd-bus-provider=basu,,basu"
PACKAGECONFIG[default-wallpaper] = "-Ddefault-wallpaper=true,-Ddefault-wallpaper=false"
PACKAGECONFIG[elogind] = "-Dsd-bus-provider=libelogind,,elogind"
PACKAGECONFIG[gdk-pixbuf] = "-Dgdk-pixbuf=enabled,-Dgdk-pixbuf=disabled,gdk-pixbuf"
PACKAGECONFIG[swaybar] = "-Dswaybar=true,-Dswaybar=false"
PACKAGECONFIG[swaynag] = "-Dswaynag=true,-Dswaynag=false"
PACKAGECONFIG[systemd] = "-Dsd-bus-provider=libsystemd,,systemd"
PACKAGECONFIG[tray] = "-Dtray=enabled,-Dtray=disabled"
PACKAGECONFIG[xwayland] = "-Dxwayland=enabled,-Dxwayland=disabled,libxcb"

PACKAGECONFIG ?= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'systemd xwayland', d)} \
	default-wallpaper \
	gdk-pixbuf \
	client \
	swaynag \
	swaybar \
"

# Reproducibility issue. Fix me!
CFLAGS:append = " -Wno-error=date-time"
EXTRA_OEMESON += "--buildtype release"

do_install:append() {
	install -m 755 ${S}/contrib/grimshot ${D}${bindir}
	install -m 755 ${S}/contrib/autoname-workspaces.py ${D}${bindir}
	install -m 755 ${S}/contrib/inactive-windows-transparency.py ${D}${bindir}
}

FILES:${PN}:append = " \
	${datadir} \
"

BBCLASSEXTEND = ""

