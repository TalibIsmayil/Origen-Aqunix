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
$greeny = new Greeny($db);


$query = "SELECT * FROM post LEFT JOIN users ON post.userid = users.id";
$stmt = $db->prepare($query);;
$stmt->execute();
$greeny_arr  =array();
$greeny_arr['greeny'] = array();
while($row = $stmt->fetch(PDO::FETCH_ASSOC)){
        extract($row);
        $greeny_item=array(
            "id" => $row['id'],
            "userid" => $row['userid'],
            "postPhoto" => $row['postPhoto'],
            "postTime" =>$greeny->time_elapsed_string_az($row['postTime']),
            "isLiked" => $row['isLiked'],
            "isSaved" =>$row['isSaved'],
            "postComment" =>$row['postComment'],
            "username" =>$row['username'],
            "photo" =>$row['photo']
        );
        array_push($greeny_arr['greeny'],$greeny_item);
    }

echo json_encode($greeny_arr['greeny'],JSON_UNESCAPED_UNICODE);