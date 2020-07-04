<?php
header('Access-Control-Origin-Allow:*');
header('Content-Type:application/json;charset');
header('Access-Control-Allow-Methods:POST');
header('Access-Control-Max-Age:3600');
header('Access-Control-Allow-Headers:Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With');
$apiKey = "9b08fc37ebd019f9ff855506d375354a";
$cityId = "587084";
$googleApiUrl = "http://api.openweathermap.org/data/2.5/weather?id=" . $cityId . "&lang=en&units=metric&APPID=" . $apiKey;

$ch = curl_init();

curl_setopt($ch, CURLOPT_HEADER, 0);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_URL, $googleApiUrl);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
curl_setopt($ch, CURLOPT_VERBOSE, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
$response = curl_exec($ch);

curl_close($ch);
$data = json_decode($response,true);
$data['imagelink'] = "http://openweathermap.org/img/w/".$data['weather'][0]['icon'].".png";
$info = array();
$info['temp'] = $data['main']['temp'];
$info['humidity'] = $data['main']['humidity'];
$info['imagelink'] = $data['imagelink'];
$info['name'] = $data['name'];

echo json_encode($info);

?>
