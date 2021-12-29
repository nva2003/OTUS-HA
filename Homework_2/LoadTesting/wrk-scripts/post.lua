-- example HTTP POST script which demonstrates setting the
-- HTTP method, body, and adding a header

--[[
wrk = {
    scheme  = "http",
    host    = "localhost",
    port    = 8080,
    method  = "POST",
    path    = "/login",
    headers = {},
    body    = "username=1&password=1",
    thread  = <userdata>,
  }
 ]]

names = { "firstName=q&lastName=q", "firstName=q&lastName=q", "firstName=q&lastName=q", "firstName=q&lastName=q"}

firstName = {"Lord","Tyrion","Jaime","Ned","Jon","robert","angel","larry"}
lastName = {"Varys","Lannister","Stark","stone","lawson","silver","warner"}



wrk.method = "POST"
wrk.body   = "username=1&password=1"
wrk.headers["Content-Type"] = "application/x-www-form-urlencoded"
wrk.host = "localhost"
-- wrk.host = "https://otus-ha-social-network.herokuapp.com"
wrk.port = 8080
-- wrk.port = nil
wrk.path = "/login"


--https://otus-ha-social-network.herokuapp.com/login

print "Hello"

-- wrk.body   = "firstNameq=q&lastName=q"
-- wrk.path = "/user/find"
-- print "HelP"


request1 = function()
    print "function_request_1"
    headers = {}
    headers["Content-Type"] = "application/x-www-form-urlencoded"
    body = "username=1&password=1"
    return wrk.format("POST", "/login", headers, body)
end

request2 = function()
    print "function_request_2"
    headers = {}
    headers["Content-Type"] = "application/x-www-form-urlencoded"
    user = "firstName="..firstName[math.random(#firstName)].."lastName="..lastName[math.random(#lastName)]
    body = user
    return wrk.format("POST", "/user/find", headers, body)
end

--[[
init = function(args)

    local requests = {}
    requests[0] = request1
    requests[1] = request2

    req = table.concat(requests)

end
 ]]

-- the request function that will run at each request
request = function()
    print "function_request"
    return request2
--[[
   -- define the path that will search for q=%v 9%v being a random
      number between 0 and 1000)
   url_path = "/somepath/search?q=" .. math.random(0,1000)-- if we want to print the path generated
   --print(url_path)-- Return the request object with the current URL path
   return wrk.format("GET", url_path)
 ]]
end

response = function(status, headers, body)
    print "function_response"
    print(Body) -- Debugging, need to be turned off when testing, because resolving Response
    if status ~= 200 then
        io.write("------------------------------\n")
        io.write("Response with status: ".. status .."\n")
        io.write("------------------------------\n")
        io.write("[response] Body:\n")
        io.write(body .. "\n")
    end
-- return wrk.format(nil, path)
end
