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

response = function(status, headers, body)
print(Body) -- Debugging, need to be turned off when testing, because resolving Response
end
