using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Xml;
using person;

//get ipEndPoint
IPHostEntry ipHostEntry = Dns.GetHostEntry(Dns.GetHostName());
IPAddress iPAddress = ipHostEntry.AddressList[0];
var ipEndPoint = new IPEndPoint(iPAddress, 1234);

//init & bind socket
var socket = new Socket(ipEndPoint.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
socket.Bind(ipEndPoint);
socket.Listen();

var person = new Person(12, "asd");
var p = new Person(69420, "Testname");

p.ToXML();
XmlDocument xmlDoc = p.ToXMLDocument(false);
string testString = Person.ToXMLString(xmlDoc);
var test = Person.FromXMLString(testString);

//while (true) to keep thread alive
while (true) {
    //init handler for async client requests
    Socket handler = socket.Accept(); var messageBuffer = new byte[1_024];
    int bytesReceived = await handler.ReceiveAsync(messageBuffer, SocketFlags.None); //await blocks until client requests
    string stringReceived = Encoding.UTF8.GetString(messageBuffer, 0, bytesReceived);
    string eom = "<EOM>";
    string converted = stringReceived.Replace(eom, "");
    Console.WriteLine($"{converted}");
}

