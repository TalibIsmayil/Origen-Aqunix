<?php
header('Access-Control-Origin-Allow:*');
header('Content-Type:application/json;charset');
header('Access-Control-Allow-Methods:POST');
header('Access-Control-Max-Age:3600');
header('Access-Control-Allow-Headers:Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With');
include_once 'config/database.php';
include_once 'classes/greeny.php';

$data     =   json_decode(file_get_contents('php://input'));
$database = new Database();
$db = $database->getConnection();
$greeny = new Greeny($db);
$keywords     = $data->s;
$search = $greeny->search($keywords);
$greeny_arr  =array();
$greeny_arr['greeny'] = array();
while($row = $search->fetch(PDO::FETCH_ASSOC)){
    extract($row);
    $greeny_item=array(
        "id" => $row['id'],
        "kindOfSoil" => $row['kindOfSoil'],
        "plantName" => $row['plantName'],
        "plantDescription" =>$row['plantSort'],
        "plantPhoto" => $row['plantPhoto']
    );
    array_push($greeny_arr['greeny'],$greeny_item);
}

echo json_encode($greeny_arr['greeny'],JSON_UNESCAPED_UNICODE);