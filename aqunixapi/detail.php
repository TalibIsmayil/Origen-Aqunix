<?php
header('Access-Control-Origin-Allow:*');
header('Content-Type:application/json;charset');
header('Access-Control-Allow-Methods:POST');
header('Access-Control-Max-Age:3600');
header('Access-Control-Allow-Headers:Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With');
include_once 'config/database.php';
include_once 'classes/greeny.php';

$database = new Database();
$db = $database->getConnection();

$data     =   json_decode(file_get_contents('php://input'));
$id = (int)$data->id;

$query = "SELECT * FROM plants WHERE id=:id";
$query2 = "SELECT * FROM details WHERE plantid=:id2";
$stmt = $db->prepare($query);
$stmt2 = $db->prepare($query2);

$stmt->bindParam(':id',$id);
$stmt2->bindParam(':id2',$id);
$stmt->execute();
$stmt2->execute();

$row = $stmt->fetch(PDO::FETCH_ASSOC);
$row2 = $stmt2->fetch(PDO::FETCH_ASSOC);

$info = array();
$info['plantPhoto'] = $row['plantPhoto'];
$info['plantTitle'] = $row['plantName'];
$info['plantDescription'] = $row2['plantDescription'];
$info['weather'] = $row2['weather'];
$info['gubreleme'] = $row2['gubreleme'];
$info['sun'] = $row2['sun'];
$info['soil'] = $row2['soil'];
$info['min'] = $row2['min'];
$info['florish'] = $row2['florish'];

echo json_encode($info,JSON_UNESCAPED_UNICODE);


echo json_encode($row, JSON_UNESCAPED_UNICODE);