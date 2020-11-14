function selectRandom(selId) {
	var s = document.getElementById(selId);
	s.selectedIndex = 1 + Math.floor(Math.random() * (s.getElementsByTagName('option').length - 1));
	return false;
}
