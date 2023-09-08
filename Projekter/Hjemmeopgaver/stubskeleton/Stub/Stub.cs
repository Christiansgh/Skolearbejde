using System.Net;
using System.Net.Sockets;
using System.Text;
using System.Xml;
using person;

//get endpoint that client sends to
IPHostEntry ipHostEntry = Dns.GetHostEntry(Dns.GetHostName());
IPAddress iPAddress = ipHostEntry.AddressList[0];
var ipEndPoint = new IPEndPoint(iPAddress, 1234);

//init socket & connect to the server listening on the endpoint
var socket = new Socket(ipEndPoint.AddressFamily, SocketType.Stream, ProtocolType.Tcp);
await socket.ConnectAsync(ipEndPoint);

//send person to the server
var person = new Person(1000, "Test???");
XmlDocument personDocument = person.ToXMLDocument(false);
string personString = Person.ToXMLString(personDocument);
byte[] personBytes = Encoding.UTF8.GetBytes(personString);
_ = await socket.SendAsync(personBytes, SocketFlags.None);
Console.WriteLine($"Client sent a message to the server.");
