void repair(Repairable r) {
	if (r instanceof Unit) {
		Unit u = (Unit)r;
	}
}
class Dropship extends AirUnit implements repairable {
}

class tank extends groundUnit implements repairable {
}
서로 관계없는 클래스들의 관계를 맺어 줄 수 있다.
