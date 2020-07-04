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


$query = "SELECT * FROM plants";
$stmt = $db->prepare($query);;
$stmt->execute();
$row = $stmt->fetchAll(PDO::FETCH_ASSOC);

echo json_encode($row, JSON_UNESCAPED_UNICODE);