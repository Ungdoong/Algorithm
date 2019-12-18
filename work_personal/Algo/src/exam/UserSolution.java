package exam;

class UserSolution {
	static class Record {
		private Record prev;
		private Record next;
		private char[][] r;

		public Record(Record n) {
			this.next = n;
		}

		public Record(char[] name, char[] number, char[] birthday, char[] email, char[] memo) {
			r = new char[5][19];
			this.r[0] = name;
			this.r[1] = number;
			this.r[2] = birthday;
			this.r[3] = email;
			this.r[4] = memo;
		}

		public Record getPrev() {
			return prev;
		}

		public void setPrev(Record prev) {
			this.prev = prev;
		}

		public Record getNext() {
			return next;
		}

		public void setNext(Record next) {
			this.next = next;
		}

		public char[] getName() {
			return r[0];
		}

		public void setName(char[] name) {
			this.r[0] = name;
		}

		public char[] getNumber() {
			return r[1];
		}

		public void setNumber(char[] number) {
			this.r[1] = number;
		}

		public char[] getBirthday() {
			return r[2];
		}

		public void setBirthday(char[] birthday) {
			this.r[2] = birthday;
		}

		public char[] getEmail() {
			return r[3];
		}

		public void setEmail(char[] email) {
			this.r[3] = email;
		}

		public char[] getMemo() {
			return r[4];
		}

		public void setMemo(char[] memo) {
			this.r[4] = memo;
		}

		public char[] getField(int field) {
			return r[field];
		}
	}

	static class List {
		private Record first;
		private Record last;

		public List() {
			first = null;
			last = null;
		}

		public int add(Record r) {
			if (first == null) {
				first = r;
				last = r;
				return 1;
			}

			last.setNext(r);
			last = r;
			return -1;
		}

		public void delete(int field, String str) {
			Record s = new Record(first);
			Record l = last;

			do {
				s = s.next;
				char[] get = s.getField(field);

			} while (s != l);
		}

		public void contains(char[] a, String b) {
			int x = 0, len = b.length();
			boolean flag = false;
			char start = b.charAt(x);

			for (int i = 0; i < a.length; i++) {
				if (!flag && a[i] == start) {
				}
			}
		}
	}

	private static List list;

	void InitDB() {
		list = new List();
	}

	void Add(String name, String number, String birthday, String email, String memo) {

	}

	int Delete(int field, String str) {
		return -1;
	}

	int Change(int field, String str, int changefield, String changestr) {
		return -1;
	}

	Solution.Result Search(int field, String str, int returnfield) {
		Solution.Result result = new Solution.Result();
		result.count = -1;

		return result;
	}
}
