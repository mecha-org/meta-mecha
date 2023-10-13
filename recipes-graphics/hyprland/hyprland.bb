
SUMMARY = "Hyprland"
HOMEPAGE = "https://github.com/hyprwm/Hyprland"
BUGTRACKER = "https://github.com/hyprwm/Hyprland/issues"
SECTION = "graphics"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=a08367f3a4cd5301ba8b88eded36b8fd"

REQUIRED_DISTRO_FEATURES = "wayland"

DEPENDS += " \
	wlroots-16 \
	cairo \
	libevdev \
	json-c \
	libdrm \
	libinput \
	libxkbcommon \
	pango \
	pcre \
	pixman \
	virtual/libgles2 \
	wayland \
	wayland-native \
	wayland-protocols \
	libpcre2 \
	xcb-util-wm \
	xcb-util \
	libxcb \
    jq \
"
# sways default config makes use of it
RDEPENDS:${PN} ?= "swaybg python3 python-i3ipc pkgconfig"

RRECOMMENDS:${PN} ?= " \
	jq \
	grim \
	slurp \
	wl-clipboard \
"

SRC_URI = " \
	git://github.com/hyprwm/Hyprland.git;protocol=https;nobranch=1 \
"

SRCREV = "3ce19e67fe60321c1af845dd30925e193cd96440"
PV = "0.24.0"
S = "${WORKDIR}/git"

inherit meson pkgconfig features_check

#PACKAGECONFIG[basu] = "-Dsd-bus-provider=basu,,basu"
#PACKAGECONFIG[default-wallpaper] = "-Ddefault-wallpaper=true,-Ddefault-wallpaper=false"
#PACKAGECONFIG[elogind] = "-Dsd-bus-provider=libelogind,,elogind"
#PACKAGECONFIG[gdk-pixbuf] = "-Dgdk-pixbuf=enabled,-Dgdk-pixbuf=disabled,gdk-pixbuf"
#PACKAGECONFIG[swaybar] = "-Dswaybar=true,-Dswaybar=false"
#PACKAGECONFIG[swaynag] = "-Dswaynag=true,-Dswaynag=false"
PACKAGECONFIG[systemd] = "-Dsystemd=enabled,-Dsystemd=disabled"
PACKAGECONFIG[legacy_renderer] = "-Dlegacy_renderer=enabled,-Dlegacy_renderer=disabled"
#PACKAGECONFIG[tray] = "-Dtray=enabled,-Dtray=disabled"
PACKAGECONFIG[xwayland] = "-Dxwayland=enabled,-Dxwayland=disabled,libxcb"

PACKAGECONFIG ?= " \
	${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
	xwayland \
"

# Reproducibility issue. Fix me!
CFLAGS:append = " -Wno-error=date-time"
EXTRA_OEMESON += "--buildtype release"

# do_install:append() {
# 	install -m 755 ${S}/contrib/grimshot ${D}${bindir}
# 	install -m 755 ${S}/contrib/autoname-workspaces.py ${D}${bindir}
# 	install -m 755 ${S}/contrib/inactive-windows-transparency.py ${D}${bindir}
# }

FILES:${PN}:append = " \
	${datadir} \
"

BBCLASSEXTEND = ""

# do_fetch_subprojects() {
#     meson subprojects update --reset
# }

# addtask fetch_subprojects after do_fetch before do_configure