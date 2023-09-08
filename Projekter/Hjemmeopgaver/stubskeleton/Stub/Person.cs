using System.Xml;

namespace person;

public class Person {
    public int? Age { get; set; }
    public string? Name { get; set; }

    public Person(int age, string name) {
        Age = age;
        Name = name;
    }

    public Person() { }

    public void ToXML() {
        var xmlDocument = ToXMLDocument(false);
        string xmlString = ToXMLString(xmlDocument);
    }

    public XmlDocument ToXMLDocument(bool saveFile) {
        //make the xml file.
        var xmlDocument = new XmlDocument();
        XmlElement personRootElement = xmlDocument.CreateElement("person");

        XmlElement ageElement = xmlDocument.CreateElement("age");
        ageElement.InnerText = $"{Age}";

        XmlElement nameElement = xmlDocument.CreateElement("name");
        nameElement.InnerText = Name;

        _ = xmlDocument.AppendChild(personRootElement);
        _ = personRootElement.AppendChild(ageElement);
        _ = personRootElement.AppendChild(nameElement);

        if (saveFile) {
            xmlDocument.Save($"{Name}_{Age}");
        }

        return xmlDocument;
    }

    public static string ToXMLString(XmlDocument xmlDocument) {
        //Handle format through settings so output is not all on one line.
        var xmlWriterSettings = new XmlWriterSettings {
            Indent = true,
            IndentChars = "    ",
            NewLineChars = "\n",
            NewLineHandling = NewLineHandling.Replace
        };

        //Convert
        var stringWriter = new StringWriter();
        var xmlWriter = XmlWriter.Create(stringWriter, xmlWriterSettings);
        xmlDocument.Save(xmlWriter);

        string unformatted = stringWriter.ToString();
        string formatted = unformatted.Replace("xmlns=''", "");

        return formatted;
    }

    public static Person FromXMLFile(string path) {
        var xmlReader = XmlReader.Create(path);
        while (xmlReader.Read()) {
            if (xmlReader.NodeType == XmlNodeType.Element && xmlReader.Name == "person") {
                var person = new Person();

                _ = xmlReader.ReadToFollowing("age");
                person.Age = xmlReader.ReadContentAsInt();

                _ = xmlReader.ReadToFollowing("name");
                person.Name = xmlReader.ReadContentAsString();
            }
        }
        return null;
    }

    public static List<Person> FromXMLString(string xmlString) {
        var xmlReader = XmlReader.Create(new StringReader(xmlString));
        var personsList = new List<Person>();
        while (xmlReader.Read()) {
            if (xmlReader.NodeType == XmlNodeType.Element && xmlReader.Name == "person") {
                var person = new Person();
                _ = xmlReader.ReadToFollowing("age");
                person.Age = xmlReader.ReadElementContentAsInt();

                _ = xmlReader.ReadToFollowing("name");
                person.Name = xmlReader.ReadElementContentAsString();

                personsList.Add(person);
            }
        }

        return personsList;
    }

    public override string ToString() {
        return $"Name:{Name}, Age:{Age} ";
    }
}
