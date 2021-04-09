package groovy_Package

class Activity1b {
	static void main(def args) {
		File file=  new File("src/groovy_package/input.txt");
		file.createNewFile();
		file.write("A quick fox jumped over the lazy cow\n")
		file.append("John jimbo jangled happlity for ever\n")
		file.append('thi$ 1$ very c0nfu$ing')
		file.eachLine {
			if (it =~ /cow$/) {
				println it
			}
			if (it =~ /^j/) {
				println it
			}
			if (it =~ /|d{2}/) {
				println it
			}
		}
		def match1= file.text=~/\S*\d\W/
		println match1.findAll()
		
		def match2= file.text=~/\S+er/
		println match2.findAll()
	}
}
