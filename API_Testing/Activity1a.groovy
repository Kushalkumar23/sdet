package groovy_Package

class Activity1a {
	static void main(def args) {
		def inputList= [11,1,17,18, "Mango", "Apple", "Watermalon"]
		def intList= inputList.minus(["Mango", "Apple", "Watermalon"])
		println intList.sort()
		
		def charList= inputList.minus(intList)
		println charList.sort()
	}
}
